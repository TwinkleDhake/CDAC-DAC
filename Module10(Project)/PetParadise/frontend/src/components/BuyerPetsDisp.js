import axios from "axios";
import React, { Component } from "react";
import Pet from "./pets";
import Bottom from "./Bottom";

class BuyerPetDisp extends Component {
  constructor(props) {
    super(props);
    this.state = { object: [] };
    this.getData();
  }

  getData = () => {
    const sess = sessionStorage.getItem("user");
    const loggedInUser = JSON.parse(sess);
    axios
      .post("http://localhost:8080/api/pets/buyerpetdisp", {
        id: loggedInUser.id,
      })
      .then((response) => {
        console.log(" before backend data");
        console.log(response.data);
        this.setState({ object: response.data });
      });
  };

  render() {
    var dis = [];
    for (const iterator of this.state.object) {
      console.log(iterator);
      dis.push(<Pet pet={iterator} />);
    }

    return (
      <>
        <div className="container">
          <div className="card-deck">
            {dis.map((value) => {
              return value;
            })}
          </div>
        </div>
        <Bottom />
      </>
    );
  }
}
export default BuyerPetDisp;
