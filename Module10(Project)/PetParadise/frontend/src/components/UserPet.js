import axios from "axios";
import React, { Component } from "react";
import Bottom from "./Bottom";
import BuyerPet from "./BuyerPets";

class UserPet extends Component {
  constructor(props) {
    super(props);
    this.state = { object: [] };
    this.getData();
  }

  getData = () => {
    const sess = sessionStorage.getItem("user");
    const loggedInUser = JSON.parse(sess);
    axios
      .post("http://localhost:8080/api/pets/viewpets", { id: loggedInUser.id })
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
      dis.push(<BuyerPet pet={iterator} />);
    }

    return (
      <>
        <div>
          {dis.map((value) => {
            return value;
          })}
        </div>
        <Bottom />
      </>
    );
  }
}
export default UserPet;
