import React, { Component } from "react";
// import Card from "react-bootstrap/Card";
// import Button from "react-bootstrap/Button";
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

class Veterinary extends Component {
  constructor(props) {
    super(props);
  }

  render() {
    return (
      <div>
        <Col>
          <Card className="mb-3">
            <CardImg
              top
              width="100%"
              src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTIPF9x71kXnyijwTMZAIi67AkyD98vh-6cIQ&usqp=CAU"
              alt="Card image cap"
            />
            <CardBody>
              <CardTitle tag="h5">Vet:{this.props.vet.name}</CardTitle>
              <CardSubtitle tag="h6" className="mb-2 text-muted">
                Hospital:{this.props.vet.hospital_name}
              </CardSubtitle>
              <CardText>Address : {this.props.vet.address}</CardText>
              <CardText>Phone No : {this.props.vet.phone}</CardText>
            </CardBody>
          </Card>
        </Col>
      </div>
    );
  }
}
export default Veterinary;
