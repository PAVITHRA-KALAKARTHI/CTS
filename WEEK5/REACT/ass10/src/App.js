import './App.css';

function App() {

  const office = {
    Name: "DBS",
    Rent: 50000,
    Address: "Chennai"
  };

  const officeList = [
    {
      Name: "DBS",
      Rent: 50000,
      Address: "Chennai"
    },
    {
      Name: "Regus",
      Rent: 75000,
      Address: "Bangalore"
    },
    {
      Name: "WeWork",
      Rent: 45000,
      Address: "Hyderabad"
    }
  ];

  return (
    <div className="App">

      <h1>Office Space, at Affordable Range</h1>

      <img
        src="/office.jpeg"
        alt="Office Space"
        width="300"
      />

      <hr />

      <h2>Single Office Details</h2>

      <h3>Name: {office.Name}</h3>

      <h3
        style={{
          color: office.Rent <= 60000 ? "red" : "green"
        }}
      >
        Rent: Rs. {office.Rent}
      </h3>

      <h3>Address: {office.Address}</h3>

      <hr />

      <h2>All Office Details</h2>

      {
        officeList.map((item, index) => (
          <div key={index} className="card">

            <h3>Name: {item.Name}</h3>

            <h3
              style={{
                color: item.Rent <= 60000 ? "red" : "green"
              }}
            >
              Rent: Rs. {item.Rent}
            </h3>

            <h3>Address: {item.Address}</h3>

            <hr />

          </div>
        ))
      }

    </div>
  );
}

export default App;