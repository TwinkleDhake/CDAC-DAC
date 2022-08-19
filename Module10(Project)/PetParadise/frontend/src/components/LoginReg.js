import React from "react";
// import Card from "react-bootstrap/Card";
import { Link } from "react-router-dom";
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
const LoginReg = () => {
  return (
    <div>
      <Card style={{ width: "30%" }}>
        <CardImg
          top
          width="10%"
          src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTrG8FG_e9TMmNdJaSEzwQRGT2PirPRE0xhag&usqp=CAU"
          alt="Card image cap"
        />
        <CardBody>
          <CardTitle tag="h5"></CardTitle>
          <CardText>Please Login Or Register...</CardText>
          <Button>
            <Link to="/login">Login</Link>
          </Button>
          &emsp; &emsp;
          <Button>
            <Link to="/signup">Registration</Link>
          </Button>
        </CardBody>
      </Card>
      <div>
        <Bottom />
      </div>
    </div>
  );
};

export default LoginReg;
