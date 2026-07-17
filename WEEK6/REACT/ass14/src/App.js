import './App.css';
import { EmployeesData } from './Employee';
import EmployeesList from './EmployeesList';
import { useState } from 'react';
import ThemeContext from './ThemeContext';

function App() {

  const [theme, setTheme] = useState("light");

  return (

    <ThemeContext.Provider value={theme}>

      <div className="App">

        <label>Select a Theme : </label>

        <select
          value={theme}
          onChange={(e) => setTheme(e.target.value)}
        >
          <option value="light">Light</option>
          <option value="dark">Dark</option>
        </select>

        <EmployeesList employees={EmployeesData} />

      </div>

    </ThemeContext.Provider>

  );

}

export default App;