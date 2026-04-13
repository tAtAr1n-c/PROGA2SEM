const menuItems = ["Home", "Random Anime", "Favourites", "Settings"];

const animeLogosTop = [
  "NARUTO",
  "BLEACH",
  "ONE PIECE",
  "JJK",
  "DEMON SLAYER",
  "AOT",
  "HXH",
  "TOKYO GHOUL",
];

const animeLogosBottom = [
  "CHAINSAW MAN",
  "DR.STONE",
  "SOLO LEVELING",
  "DEATH NOTE",
  "JOJO",
  "VINLAND SAGA",
  "BLUE LOCK",
  "BLACK CLOVER",
];

const HUMAN_CHARACTER_SRC = "./assets/character-human.jpeg";
const GHOUL_CHARACTER_SRC = "./assets/character-ghoul.jpeg";

async function prepareTransparentCharacter(src) {
  const image = await new Promise((resolve, reject) => {
    const img = new Image();
    img.onload = () => resolve(img);
    img.onerror = reject;
    img.src = src;
  });

  const canvas = document.createElement("canvas");
  const width = image.naturalWidth;
  const height = image.naturalHeight;

  canvas.width = width;
  canvas.height = height;

  const context = canvas.getContext("2d");
  if (!context) return src;

  context.drawImage(image, 0, 0, width, height);

  const imageData = context.getImageData(0, 0, width, height);
  const pixels = imageData.data;
  const corners = [
    [0, 0],
    [width - 1, 0],
    [0, height - 1],
    [width - 1, height - 1],
  ];

  let bgR = 0;
  let bgG = 0;
  let bgB = 0;

  corners.forEach(([x, y]) => {
    const idx = (y * width + x) * 4;
    bgR += pixels[idx];
    bgG += pixels[idx + 1];
    bgB += pixels[idx + 2];
  });

  bgR /= corners.length;
  bgG /= corners.length;
  bgB /= corners.length;

  const tolerance = 38;
  const queue = [];
  const visited = new Uint8Array(width * height);

  function withinBackground(x, y) {
    const pixelIndex = (y * width + x) * 4;
    const r = pixels[pixelIndex];
    const g = pixels[pixelIndex + 1];
    const b = pixels[pixelIndex + 2];

    const distance = Math.abs(r - bgR) + Math.abs(g - bgG) + Math.abs(b - bgB);
    return distance <= tolerance;
  }

  function addPoint(x, y) {
    if (x < 0 || x >= width || y < 0 || y >= height) return;
    const idx = y * width + x;
    if (visited[idx]) return;
    if (!withinBackground(x, y)) return;

    visited[idx] = 1;
    queue.push(idx);
  }

  for (let x = 0; x < width; x += 1) {
    addPoint(x, 0);
    addPoint(x, height - 1);
  }

  for (let y = 0; y < height; y += 1) {
    addPoint(0, y);
    addPoint(width - 1, y);
  }

  while (queue.length > 0) {
    const index = queue.pop();
    const x = index % width;
    const y = Math.floor(index / width);

    addPoint(x + 1, y);
    addPoint(x - 1, y);
    addPoint(x, y + 1);
    addPoint(x, y - 1);
  }

  for (let i = 0; i < visited.length; i += 1) {
    if (!visited[i]) continue;
    pixels[i * 4 + 3] = 0;
  }

  context.putImageData(imageData, 0, 0);
  return canvas.toDataURL("image/png");
}

function Header({ onAuthRequest }) {
  const [logoError, setLogoError] = React.useState(false);
  const [profileOpen, setProfileOpen] = React.useState(false);
  const profileRef = React.useRef(null);

  React.useEffect(() => {
    function handleOutsideClick(event) {
      if (!profileRef.current?.contains(event.target)) {
        setProfileOpen(false);
      }
    }

    document.addEventListener("pointerdown", handleOutsideClick);

    return () => {
      document.removeEventListener("pointerdown", handleOutsideClick);
    };
  }, []);

  function openAuth(mode) {
    setProfileOpen(false);
    onAuthRequest(mode);
  }

  return (
    <header className="topbar shell">
      <a className="logo" href="#">
        {logoError ? (
          <span className="logo-fallback" aria-label="AniViewer">
            AniViewer
          </span>
        ) : (
          <img
            className="logo-image"
            src="./assets/site-avatar.png"
            alt="AniViewer"
            onError={() => setLogoError(true)}
          />
        )}
      </a>

      <nav className="menu" aria-label="Главное меню">
        {menuItems.map((item) => (
          <a key={item} href="#">
            {item}
          </a>
        ))}
      </nav>

      <label className="search-box" aria-label="Поиск">
        <span className="search-icon">⌕</span>
        <input type="text" placeholder="Поиск" />
      </label>

      <div className="profile-wrap" ref={profileRef}>
        <button
          className="profile"
          type="button"
          aria-label="Профиль"
          aria-expanded={profileOpen}
          onClick={() => setProfileOpen((prev) => !prev)}
        >
          <span className="avatar" aria-hidden="true">
            <span className="avatar-head" />
            <span className="avatar-body" />
          </span>
          <span className="profile-text">Профиль</span>
        </button>

        {profileOpen ? (
          <div className="profile-dropdown" role="menu" aria-label="Профиль меню">
            <button type="button" onClick={() => openAuth("signIn")}>
              Log In
            </button>
            <button type="button" onClick={() => openAuth("signUp")}>
              Sign Up
            </button>
          </div>
        ) : null}
      </div>
    </header>
  );
}

function Hero() {
  const revealRef = React.useRef(null);
  const cursorRef = React.useRef(null);
  const [isRevealActive, setIsRevealActive] = React.useState(false);
  const [characters, setCharacters] = React.useState({
    human: HUMAN_CHARACTER_SRC,
    ghoul: GHOUL_CHARACTER_SRC,
  });

  React.useEffect(() => {
    let cancelled = false;

    Promise.all([prepareTransparentCharacter(HUMAN_CHARACTER_SRC), prepareTransparentCharacter(GHOUL_CHARACTER_SRC)])
      .then(([human, ghoul]) => {
        if (!cancelled) {
          setCharacters({ human, ghoul });
        }
      })
      .catch(() => {
        if (!cancelled) {
          setCharacters({
            human: HUMAN_CHARACTER_SRC,
            ghoul: GHOUL_CHARACTER_SRC,
          });
        }
      });

    return () => {
      cancelled = true;
    };
  }, []);

  function updateRevealPosition(clientX, clientY) {
    const revealNode = revealRef.current;
    if (!revealNode) return;

    const rect = revealNode.getBoundingClientRect();
    const x = Math.max(0, Math.min(clientX - rect.left, rect.width));
    const y = Math.max(0, Math.min(clientY - rect.top, rect.height));

    revealNode.style.setProperty("--reveal-x", `${x}px`);
    revealNode.style.setProperty("--reveal-y", `${y}px`);

    if (cursorRef.current) {
      cursorRef.current.style.setProperty("--cursor-x", `${x}px`);
      cursorRef.current.style.setProperty("--cursor-y", `${y}px`);
    }
  }

  function handlePointerEnter(event) {
    setIsRevealActive(true);
    updateRevealPosition(event.clientX, event.clientY);
  }

  function handlePointerMove(event) {
    updateRevealPosition(event.clientX, event.clientY);
  }

  function handlePointerLeave() {
    setIsRevealActive(false);
  }

  return (
    <section className="hero shell">
      <div className="hero-figure" aria-label="Центральный персонаж">
        <div className="figure-glow" />
        <div
          ref={revealRef}
          className={`hero-character-stage character-reveal ${isRevealActive ? "is-active" : ""}`}
          onPointerEnter={handlePointerEnter}
          onPointerMove={handlePointerMove}
          onPointerLeave={handlePointerLeave}
        >
          <img className="layer base" src={characters.human} alt="Human form" />
          <img className="layer top" src={characters.ghoul} alt="Transformation form" />
          <span ref={cursorRef} className="reveal-cursor" aria-hidden="true" />
        </div>
      </div>
    </section>
  );
}

function MarqueeRow({ items, speedClass }) {
  const loop = [...items, ...items];

  return (
    <div className="marquee-row">
      <div className={`marquee-track ${speedClass}`}>
        {loop.map((name, idx) => (
          <span key={`${name}-${idx}`} className="anime-chip">
            {name}
          </span>
        ))}
      </div>
    </div>
  );
}

function AnimeRibbon() {
  return (
    <section className="anime-ribbon">
      <div className="shell ribbon-shell">
        <MarqueeRow items={animeLogosTop} speedClass="speed-fast" />
        <MarqueeRow items={animeLogosBottom} speedClass="speed-slow" />
      </div>
    </section>
  );
}

function ContactStrip() {
  return (
    <footer className="contact-strip">
      <div className="shell contact-inner">
        <span className="contact-title">Обратная связь</span>
        <a href="https://t.me/AniViewBots" target="_blank" rel="noreferrer">
          Telegram
        </a>
        <a href="#">Discord</a>
        <a href="#">Email</a>
      </div>
    </footer>
  );
}

function AuthPage({ initialMode, onBack }) {
  const [mode, setMode] = React.useState(initialMode);

  React.useEffect(() => {
    setMode(initialMode);
  }, [initialMode]);

  function stopSubmit(event) {
    event.preventDefault();
  }

  const signUpActive = mode === "signUp";

  return (
    <section className="auth-page">
      <div className={`auth-shell ${signUpActive ? "is-sign-up" : ""}`}>
        <button type="button" className="auth-back" onClick={onBack}>
          ← Back To Home
        </button>

        <div className="auth-form-wrap auth-sign-up">
          <form className="auth-form" onSubmit={stopSubmit}>
            <h2>Create Account</h2>
            <p>Use email for registration</p>
            <input type="text" placeholder="Full Name" />
            <input type="email" placeholder="Email Address" />
            <input type="password" placeholder="Password" />
            <button type="submit" className="auth-primary-btn">
              Sign Up
            </button>
          </form>
        </div>

        <div className="auth-form-wrap auth-sign-in">
          <form className="auth-form" onSubmit={stopSubmit}>
            <h2>Sign In</h2>
            <p>Use your account</p>
            <input type="email" placeholder="Email Address" />
            <input type="password" placeholder="Password" />
            <a className="auth-link" href="#">
              Forgot your password?
            </a>
            <button type="submit" className="auth-primary-btn">
              Log In
            </button>
          </form>
        </div>

        <div className="auth-overlay-wrap" aria-hidden="true">
          <div className="auth-overlay">
            <div className="auth-overlay-pane auth-overlay-left">
              <h3>Welcome Back!</h3>
              <p>Stay connected by logging in and continue your anime journey.</p>
              <button type="button" className="auth-ghost-btn" onClick={() => setMode("signIn")}>
                Log In
              </button>
            </div>

            <div className="auth-overlay-pane auth-overlay-right">
              <h3>Hey There!</h3>
              <p>Create your profile and save favourite anime in one place.</p>
              <button type="button" className="auth-ghost-btn" onClick={() => setMode("signUp")}>
                Sign Up
              </button>
            </div>
          </div>
        </div>
      </div>
    </section>
  );
}

function App() {
  const [page, setPage] = React.useState("home");
  const [authMode, setAuthMode] = React.useState("signIn");

  function openAuth(mode) {
    setAuthMode(mode);
    setPage("auth");
  }

  function openHome() {
    setPage("home");
  }

  if (page === "auth") {
    return <AuthPage initialMode={authMode} onBack={openHome} />;
  }

  return (
    <>
      <Header onAuthRequest={openAuth} />
      <main>
        <Hero />
        <AnimeRibbon />
      </main>
      <ContactStrip />
    </>
  );
}

ReactDOM.createRoot(document.getElementById("root")).render(<App />);
