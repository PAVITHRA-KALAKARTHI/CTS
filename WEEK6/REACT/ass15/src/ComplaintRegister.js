import React, { Component } from "react";

class ComplaintRegister extends Component {

    constructor() {

        super();

        this.state = {

            ename: "",
            complaint: "",
            NumberHolder: Math.floor(Math.random() * 1000)

        };

    }

    handleChange = (event) => {

        this.setState({

            [event.target.name]: event.target.value

        });

    };

    handleSubmit = (event) => {

        alert(
            "Thanks " +
            this.state.ename +
            "\nYour Complaint was Submitted.\nReference ID is : " +
            this.state.NumberHolder
        );

        event.preventDefault();

    };

    render() {

        return (

            <div>

                <h1 style={{ color: "red" }}>
                    Register your complaints here!!!
                </h1>

                <form onSubmit={this.handleSubmit}>

                    <table align="center">

                        <tbody>

                            <tr>

                                <td>Name</td>

                                <td>

                                    <input
                                        type="text"
                                        name="ename"
                                        value={this.state.ename}
                                        onChange={this.handleChange}
                                    />

                                </td>

                            </tr>

                            <tr>

                                <td>Complaint</td>

                                <td>

                                    <textarea
                                        name="complaint"
                                        value={this.state.complaint}
                                        onChange={this.handleChange}
                                    />

                                </td>

                            </tr>

                            <tr>

                                <td></td>

                                <td>

                                    <input
                                        type="submit"
                                        value="Submit"
                                    />

                                </td>

                            </tr>

                        </tbody>

                    </table>

                </form>

            </div>

        );

    }

}

export default ComplaintRegister;