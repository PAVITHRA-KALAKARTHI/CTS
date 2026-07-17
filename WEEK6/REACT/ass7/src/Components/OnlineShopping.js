import React, { Component } from "react";
import Cart from "./Cart";

class OnlineShopping extends Component {

    constructor() {

        super();

        this.items = [

            {
                Itemname: "Laptop",
                Price: 65000
            },

            {
                Itemname: "Mobile",
                Price: 25000
            },

            {
                Itemname: "Headphones",
                Price: 3000
            },

            {
                Itemname: "Keyboard",
                Price: 1500
            },

            {
                Itemname: "Mouse",
                Price: 800
            }

        ];

    }

    render() {

        return (

            <div>

                <h1>Online Shopping</h1>

                <table border="1" cellPadding="10">

                    <thead>

                        <tr>

                            <th>Item Name</th>

                            <th>Price</th>

                        </tr>

                    </thead>

                    <tbody>

                        {

                            this.items.map((item, index) => (

                                <Cart

                                    key={index}

                                    Itemname={item.Itemname}

                                    Price={item.Price}

                                />

                            ))

                        }

                    </tbody>

                </table>

            </div>

        );

    }

}

export default OnlineShopping;