import React, { useState } from "react";
import axios from "axios";
import Bottom from "../Bottom";
import { Link } from "react-router-dom";
const SavePetVet = () => {
  const [vet, setVet] = useState({
    vetName: "",
    hospitalName: "",
    address: "",
    phone: "",
  });
  const [people, setPeople] = useState([]);
  const handleChange = (e) => {
    const name = e.target.name;
    const value = e.target.value;
    setVet({ ...vet, [name]: value });
  };
  const handleSubmit = (e) => {
    e.preventDefault();
    if (vet.vetName && vet.hospitalName && vet.address && vet.phone) {
      axios
        .post("http://localhost:8080/api/veterinary/saveveterinary", {
          name: vet.vetName,
          hospital_name: vet.hospitalName,
          address: vet.address,
          phone: vet.phone,
        })
        .then((response) => {
          console.log(response.data);
        })
        .catch((error) => {
          console.log(error.response);
        });
      setVet({
        vetName: "",
        hospitalName: "",
        address: "",
        phone: "",
      });
      window.location.reload(false);
    }
  };
  return (
    <>
      <section className="vh-100">
        <div className="container h-100">
          <div className="row d-flex justify-content-center align-items-center h-100">
            <div className="col-lg-8 col-xl-9">
              <div className="card text-black" style={{ borderRadius: "25px" }}>
                <div className="card-body p-md-5">
                  <div className="row justify-content-center">
                    <div className="col-md-10 col-lg-6 col-xl-7 order-2 order-lg-1">
                      <p className="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">
                        Veterinary's info
                      </p>

                      <form className="mx-1 mx-md-4">
                        <div className="d-flex flex-row align-items-center mb-4">
                          <i className="fas fa-user fa-lg me-3 fa-fw"></i>
                          <div className="form-outline flex-fill mb-0">
                            <input
                              type="text"
                              id="vetName"
                              name="vetName"
                              className="form-control"
                              placeholder="Vet Name"
                              value={vet.vetName}
                              onChange={handleChange}
                            />
                          </div>
                        </div>

                        <div className="d-flex flex-row align-items-center mb-4">
                          <i className="fas fa-hotel fa-lg me-3 fa-fw"></i>
                          <div className="form-outline flex-fill mb-0">
                            <input
                              type="text"
                              id="hospitalName"
                              name="hospitalName"
                              className="form-control"
                              placeholder="Hospital Name"
                              value={vet.hospitalName}
                              onChange={handleChange}
                            />
                          </div>
                        </div>

                        <div className="d-flex flex-row align-items-center mb-4">
                          <i className="fas fa-user fa-lg me-3 fa-fw"></i>
                          <div className="form-outline flex-fill mb-0">
                            <input
                              type="text"
                              id="address"
                              name="address"
                              className="form-control"
                              placeholder="Address"
                              value={vet.address}
                              onChange={handleChange}
                            />
                          </div>
                        </div>

                        <div className="d-flex flex-row align-items-center mb-4">
                          <i class="fas fa-phone fa-lg me-3 fa-fw"></i>
                          <div className="form-outline flex-fill mb-0">
                            <input
                              type="number"
                              id="phone"
                              name="phone"
                              className="form-control"
                              placeholder="Phone No"
                              value={vet.phone}
                              onChange={handleChange}
                            />
                          </div>
                        </div>

                        <div className="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
                          <button
                            type="submit"
                            className="btn btn-primary btn-lg"
                            onClick={handleSubmit}
                          >
                            <Link to="/allveterinary" className="text-white">
                              Good to Go!!
                            </Link>
                          </button>
                        </div>
                      </form>
                    </div>
                    <div className="col-md-10 col-lg-6 col-xl-5 d-flex align-items-center order-1 order-lg-2">
                      <img
                        src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSFQx9JHm_y9ETlxlIS2lMCMB70ymENgF-bVQ&usqp=CAU"
                        className="img-fluid"
                        alt="Sample image"
                      />
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
      <Bottom />
    </>
  );
};

export default SavePetVet;
