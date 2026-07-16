import { useState } from "react";

import GuestGreeting from "./Components/GuestGreeting";
import UserGreeting from "./Components/UserGreeting";
import LoginButton from "./Components/LoginButton";
import LogoutButton from "./Components/LogoutButton";

function App() {

  const [isLoggedIn, setIsLoggedIn] = useState(false);

  const handleLogin = () => {
    setIsLoggedIn(true);
  };

  const handleLogout = () => {
    setIsLoggedIn(false);
  };

  return (
    <div style={{ margin: "30px" }}>

      {isLoggedIn ? <UserGreeting /> : <GuestGreeting />}

      <br />

      {isLoggedIn ? (
        <LogoutButton onClick={handleLogout} />
      ) : (
        <LoginButton onClick={handleLogin} />
      )}

    </div>
  );
}

export default App;