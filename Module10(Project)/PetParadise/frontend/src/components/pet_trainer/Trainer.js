import React, { Component } from "react";
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

class Trainer extends Component {
  constructor(props) {
    super(props);
  }

  render() {
    return (
      // <>
      //   <div className="d-flex justify-content-center mb-3 container-fluid">
      //     <div className="col-6">
      //       <Card
      //         style={{ width: "20rem" }}
      //         className="box"
      //       >
      //         <Card.Img
      //           variant="top"
      //           src="https://www.humanesociety.org/sites/default/files/styles/1240x698/public/2018/06/kittens-in-shelter-69469.jpg?h=ece64c50&itok=tOiKeqHY"
      //         />
      //         <Card.Body>
      //           <Card.Title>
      //             <h3 class="card-title">Trainer:{this.props.trainer.name}</h3>
      //           </Card.Title>
      //           <Card.Title>
      //             Trainning Center:{this.props.trainer.center_name}
      //           </Card.Title>
      //           <Card.Text>
      //             <b>Address : {this.props.trainer.address}</b>
      //           </Card.Text>
      //           <b>Phone No : {this.props.trainer.phone}</b>
      //         </Card.Body>
      //       </Card>
      //     </div>
      //   </div>
      // </>

      // ==================================================================================================

      // <div className=" d-flex justify-content-center mb-3 container-fluid">
      //   <div className="col-6">
      //     <Card>
      //       <Card.Img
      //         variant="top"
      //         src="https://www.humanesociety.org/sites/default/files/styles/1240x698/public/2018/06/kittens-in-shelter-69469.jpg?h=ece64c50&itok=tOiKeqHY"
      //       />
      //       <Card.Body>
      //         <Card.Text>
      //           Trainer:{this.props.trainer.name}
      //            Trainning Center:{this.props.trainer.center_name}
      //           Address : {this.props.trainer.address}
      //            Phone No : {this.props.trainer.phone}
      //         </Card.Text>
      //       </Card.Body>
      //     </Card>
      //   </div>
      // </div>

      // =======================================================================================================================

      <div>
        <Col>
          <Card className="mb-3">
            <CardImg
              top
              width="100%"
              src="data:image/jpeg;base64,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"
              alt="Card image cap"
            />
            <CardBody>
              <CardTitle tag="h5">Trainer:{this.props.trainer.name}</CardTitle>
              <CardSubtitle tag="h6" className="mb-2 text-muted">
                Trainning Center:{this.props.trainer.center_name}
              </CardSubtitle>
              <CardText>Address : {this.props.trainer.address}</CardText>
              <CardText>Phone No : {this.props.trainer.phone}</CardText>
            </CardBody>
          </Card>
        </Col>
      </div>
    );
  }
}
export default Trainer;
