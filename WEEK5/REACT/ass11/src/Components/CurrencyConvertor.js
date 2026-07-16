import { useState } from "react";

function CurrencyConvertor() {

    const [amount, setAmount] = useState("");
    const [currency, setCurrency] = useState("");

    const handleSubmit = (e) => {

        e.preventDefault();

        let euro = amount / 90;

        alert(
            "Converting to Euro Amount is " +
            euro.toFixed(2)
        );
    };

    return (

        <div>

            <h1 style={{ color: "green" }}>
                Currency Convertor!!!
            </h1>

            <form onSubmit={handleSubmit}>

                <div>

                    Amount

                    <input
                        type="number"
                        value={amount}
                        onChange={(e) =>
                            setAmount(e.target.value)
                        }
                    />

                </div>

                <br />

                <div>

                    Currency

                    <input
                        type="text"
                        value={currency}
                        onChange={(e) =>
                            setCurrency(e.target.value)
                        }
                    />

                </div>

                <br />

                <button type="submit">
                    Submit
                </button>

            </form>

        </div>

    );

}

export default CurrencyConvertor;