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
  Container,
} from "reactstrap";
import Bottom from "./Bottom";

class BuyerPet extends Component {
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
      // window.location = "/sellerinfo";
    } else {
      console.log("Login First");
      window.location = "http://localhost:3000/loginreg";
    }
  };

  render() {
    return (
      <>
        <div className="col-3">
          <Col>
            <Card className="mb-3">
              <CardImg
                top
                width="100%"
                src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTtjXZl7__K2KBO7r9lOc5n2yd3tUk36snfjQ&usqp=CAU"
                alt="Card image cap"
              />
              <CardBody>
                <CardTitle tag="h5">Breed:{this.props.pet.breed}</CardTitle>
                <CardSubtitle tag="h6" className="mb-2 text-muted">
                  Name:{this.props.pet.petname}
                </CardSubtitle>
                <CardText>Price:{this.props.pet.price}</CardText>
              </CardBody>
            </Card>
          </Col>
        </div>
      </>
    );
  }
}
export default BuyerPet;
