import axios from "axios";
import React, { Component } from "react";
import Pet from "./pets";
import Bottom from "./Bottom";

import { Link } from "react-router-dom";
class PetCards extends Component {
  constructor(props) {
    super(props);
    this.state = { object: [] };
    var pet;
    this.getData();
  }

  getData = () => {
    var sess = sessionStorage.getItem("pet");
    console.log("data of user");
    console.log(sess);
    console.log("pases data");
    this.pet = JSON.parse(sess);
    console.log(this.pet);
    console.log("------------" + this.xyz);
    axios
      .post("http://localhost:8080/api/pets/getpets", { id: this.pet.id })
      .then((response) => {
        console.log(" before backend data");
        console.log(response.data);
        this.setState({ object: response.data });
      });
  };

  setPet = () => {
    const sess = sessionStorage.getItem("pet");
    const pet = JSON.parse(sess);
    const sess1 = sessionStorage.getItem("user");
    const loggedInUser = JSON.parse(sess1);
    axios
      .post("http://localhost:8080/api/pets/buypets", {
        id: pet.id,
        petname: pet.petName,
        type: pet.type,
        breed: pet.breed,
        age: pet.age,
        color: pet.color,
        gender: pet.gender,
        price: pet.price,
        status: pet.status,
        uid: loggedInUser.id,
      })
      .then((response) => {
        console.log(" before backend data");
        console.log(response.data);
        this.setState({ object: response.data });
        window.location = "http://localhost:3000/buyerprofile";
      });
  };
  render() {
    return (
      <>
        <div>
          <div
            style={{
              backgroundImage:
                "linear-gradient(to right top, #208322, #1b732c, #1c6332, #205333, #254332)",
            }}
          >
            <div class="container vh-100 w-50">
              <div class="row d-flex justify-content-center mt-4">
                <div class="col-md-10 mt-5 pt-5">
                  <div class=" z-depth-3">
                    <div class="col-sm-12 bg-success rounded-left">
                      <div class="card-block text-center text-white">
                        <i class="fas fa-id-card fa-7x mt-5 mb-5"></i>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <div class="row d-flex justify-content-center">
                <div class="col-md-10 ">
                  <div class=" z-depth-3">
                    <div class="col-sm-12 bg-white rounded-right pb-3">
                      <h3 class=" p-2 text-center font-weight-bold">
                        <b>SELLER PROFILE CARD</b>
                      </h3>
                      <hr class="badge-primary mt-0 " />
                      <div class="row">
                        <div class="col-sm-12">
                          <h3 class="font-weight-bold">
                            {/* Full Name : {sess != null ? loggedInUser.fname : "name"} */}
                            Full Name :{this.state.object.fname}{" "}
                            {this.state.object.lname}
                          </h3>
                        </div>
                      </div>
                      <hr class="bg-primary" />
                      <div class="row">
                        <div class="col-sm-12">
                          <h3 class="font-weight-bold">
                            {/* Email ID : {sess != null ? userdata.email : "email"} */}
                            Email ID : {this.state.object.email}
                          </h3>
                        </div>
                      </div>
                      <hr class="bg-primary" />
                      <div class="row">
                        <div class="col-sm-12">
                          <h3 class="font-weight-bold">
                            {/* City:{sess != null ? userdata.city : "city"} */}
                            Phone No :{this.state.object.phone_no}
                          </h3>
                        </div>
                      </div>
                      <hr class="bg-primary" />
                      <div class="row">
                        <div class="col-sm-12">
                          <h3 class="font-weight-bold">
                            {/* Phone : {sess != null ? userdata.phone : "phone"} */}
                            Adhar No : {this.state.object.aadhaar_no}
                          </h3>
                          <hr />
                        </div>
                      </div>
                      {/* <button className="btn btn-primary"><Link to="/buyerprofile" className="text-white">Buy Pet</Link></button> */}
                      <button className="btn btn-primary" onClick={this.setPet}>
                        Buy Pet
                      </button>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <Bottom />
        </div>
      </>
    );
  }
}
export default PetCards;

// import React from "react";
// import "./profile.css";
// import Bottom from "./Bottom";
// import axios from "axios";

// function SellerInfo() {
//   const sess = sessionStorage.getItem("user");
// //   console.log("data of user");
// //   console.log(sess);
// //   console.log("pases data");
// //   console.log(JSON.parse(sess));
//   const loggedInUser = JSON.parse(sess);

//   const sess1 = sessionStorage.getItem("pet");
//   console.log("data of pet data");
//   console.log(sess1);
//   console.log("pases data");
//   console.log(JSON.parse(sess1));

//   return (
// <div>
//   <div
//     style={{
//       backgroundImage:
//         "linear-gradient(to right top, #208322, #1b732c, #1c6332, #205333, #254332)",
//     }}
//   >
//     <div class="container vh-100 w-50">
//       <div class="row d-flex justify-content-center mt-4">
//         <div class="col-md-10 mt-5 pt-5">
//           <div class=" z-depth-3">
//             <div class="col-sm-12 bg-success rounded-left">
//               <div class="card-block text-center text-white">
//                 <i class="fas fa-id-card fa-7x mt-5 mb-5"></i>
//               </div>
//             </div>
//           </div>
//         </div>
//       </div>
//       <div class="row d-flex justify-content-center">
//         <div class="col-md-10 ">
//           <div class=" z-depth-3">
//             <div class="col-sm-12 bg-white rounded-right pb-3">
//               <h3 class=" p-2 text-center font-weight-bold">
//                 <b>PROFILE CARD</b>
//               </h3>
//               <hr class="badge-primary mt-0 " />
//               <div class="row">
//                 <div class="col-sm-12">
//                   <h3 class="font-weight-bold">
//                     {/* Full Name : {sess != null ? loggedInUser.fname : "name"} */}
//                     Full Name : {loggedInUser.fname} {loggedInUser.lname}
//                   </h3>
//                 </div>
//               </div>
//               <hr class="bg-primary" />
//               <div class="row">
//                 <div class="col-sm-12">
//                   <h3 class="font-weight-bold">
//                     {/* Email ID : {sess != null ? userdata.email : "email"} */}
//                     Email ID : {loggedInUser.email}
//                   </h3>
//                 </div>
//               </div>
//               <hr class="bg-primary" />
//               <div class="row">
//                 <div class="col-sm-12">
//                   <h3 class="font-weight-bold">
//                     {/* City:{sess != null ? userdata.city : "city"} */}
//                     Phone No :{loggedInUser.phone_no}
//                   </h3>
//                 </div>
//               </div>
//               <hr class="bg-primary" />
//               <div class="row">
//                 <div class="col-sm-12">
//                   <h3 class="font-weight-bold">
//                     {/* Phone : {sess != null ? userdata.phone : "phone"} */}
//                     Adhar No : {loggedInUser.aadhaar_no}
//                   </h3>
//                   <hr />
//                 </div>
//               </div>
//             </div>
//           </div>
//         </div>
//       </div>
//     </div>
//   </div>
//   <Bottom />
// </div>
//   );
// }

// export default SellerInfo;
