import React from "react";

export default function ListofPlayers(props) {

    const players70 = props.players.filter(player => player.score <= 70);

    return (
        <div>

            {props.players.map((item, index) => (
                <li key={index}>
                    Mr. {item.name} <span>{item.score}</span>
                </li>
            ))}

            <hr />

            <h2>List of Players having Scores Less than 70</h2>

            {players70.map((item, index) => (
                <li key={index}>
                    Mr. {item.name} <span>{item.score}</span>
                </li>
            ))}

        </div>
    );
}