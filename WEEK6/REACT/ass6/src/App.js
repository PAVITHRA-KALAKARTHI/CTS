import { BrowserRouter, Routes, Route, Link } from "react-router-dom";

import Home from "./Components/Home";
import TrainersList from "./Components/TrainersList";
import TrainerDetails from "./Components/TrainerDetails";

function App() {
  return (
    <BrowserRouter>

      <h1>My Academy Portal</h1>

      <nav>
        <Link to="/">Home</Link> |{" "}
        <Link to="/trainers">Show Trainers</Link>
      </nav>

      <hr />

      <Routes>

        <Route path="/" element={<Home />} />

        <Route path="/trainers" element={<TrainersList />} />

        <Route path="/trainers/:id" element={<TrainerDetails />} />

      </Routes>

    </BrowserRouter>
  );
}

export default App;