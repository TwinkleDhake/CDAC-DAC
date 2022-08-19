import React, { Component } from "react";
import { Link } from "react-router-dom";
// import Bottom from "./Bottom";
import {
  Card,
  CardImg,
  CardText,
  CardBody,
  CardTitle,
  CardSubtitle,
  Button,
  Col,
} from "reactstrap";
import Bottom from "./Bottom";

class Pet extends Component {
  constructor(props) {
    super(props);
  }
  userCheck = () => {
    var sess = sessionStorage.getItem("user");
    console.log(sess);
    if (sess != null) {
      sessionStorage.setItem("pet", JSON.stringify(this.props.pet));
      var pet_data = sessionStorage.getItem("pet");
      console.log("****************" + pet_data);
      window.location.href = "http://localhost:3000/sellerinfo";
    } else {
      console.log("Login First");
      window.location.href = "http://localhost:3000/loginreg";
    }
  };

  render() {
    return (
      <>
        <div>
          <Card>
            <CardImg
              top
              width="10%"
              hight="1%"
              src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTtjXZl7__K2KBO7r9lOc5n2yd3tUk36snfjQ&usqp=CAU"
              alt="Card image cap"
            />
            <CardTitle tag="h5">Breed:{this.props.pet.breed}</CardTitle>
            <hr />
            <CardBody>
              <CardSubtitle>Name:{this.props.pet.petname}</CardSubtitle>
              <CardTitle>Price:{this.props.pet.price}</CardTitle>
            </CardBody>
            <hr />
            <button className="btn btn-dark mb-3" onClick={this.userCheck}>
              buy
            </button>
          </Card>
        </div>
      </>
    );
  }
}
export default Pet;
