import axios from "axios";
import React, { Component } from "react";
import Trainer from "./Trainer";

class TrainerCards extends Component {
  constructor(props) {
    super(props);
    this.state = { object: [] };
    this.getData();
  }

  getData = () => {
    axios
      .get("http://localhost:8080/api/trainer/alltrainer")
      .then((response) => {
        console.log(" before backend data");
        this.setState({ object: response.data });
      });
  };

  render() {
    var dis = [];
    for (const iterator of this.state.object) {
      console.log(iterator);
      dis.push(<Trainer trainer={iterator} />);
    }

    return (
      <div className="container ">
        <div className="card-deck ">
          {dis.map((value) => {
            return value;
          })}
        </div>
      </div>
    );
  }
}
export default TrainerCards;
