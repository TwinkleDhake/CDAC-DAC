import React, { useState } from "react";
import axios from "axios";
import { Link } from "react-router-dom";
import Bottom from "./Bottom";
import { ToastContainer, toast } from "react-toastify";

const AddPet = () => {
  const [pet, setPet] = useState({
    petName: "",
    type: "",
    breed: "",
    age: "",
    color: "",
    gender: "",
    price: "",
    status: "",
    uid: "",
  });
  // const [people, setPeople] = useState([]);
  const handleChange = (e) => {
    const name = e.target.name;
    const value = e.target.value;
    setPet({ ...pet, [name]: value });
  };
  const handleSubmit = (e) => {
    e.preventDefault();
    const sess = sessionStorage.getItem("user");
    const loggedInUser = JSON.parse(sess);
    if (
      pet.petName &&
      pet.type &&
      pet.breed &&
      pet.age &&
      pet.color &&
      pet.gender &&
      pet.price &&
      pet.status &&
      loggedInUser.id
    ) {
      axios
        .post("http://localhost:8080/api/pets/addpet", {
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
          console.log(response.data);
          setPet({
            petName: "",
            type: "",
            breed: "",
            age: "",
            color: "",
            gender: "",
            price: "",
            status: "",
          });
          toast.success("Pet Added. visit Profile to view.", {
            position: "bottom-center",
            autoClose: false,
          });
        })
        .catch((error) => {
          console.log(error.response);
          toast.error("Something went wrong..");
        });

      setPet({
        petName: "",
        type: "",
        breed: "",
        age: "",
        color: "",
        gender: "",
        price: "",
        status: "",
      });
    }
  };
  return (
    <>
      <section className="vh-120">
        <div className="container h-100">
          <ToastContainer />
          <div className="row d-flex justify-content-center align-items-center h-100">
            <div className="col-lg-8 col-xl-9">
              <div className="card text-black" style={{ borderRadius: "25px" }}>
                <div className="card-body p-md-5">
                  <div className="row justify-content-center">
                    <div className="col-md-10 col-lg-6 col-xl-7 order-2 order-lg-1">
                      <p className="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">
                        Pet's Page
                      </p>

                      <form className="mx-1 mx-md-4">
                        <div className="d-flex flex-row align-items-center mb-4">
                          <i class="fas fa-paw fa-lg me-3 fa-fw"></i>
                          <div className="form-outline flex-fill mb-0">
                            <input
                              type="text"
                              id="petName"
                              name="petName"
                              className="form-control"
                              placeholder="Pet's Name"
                              value={pet.petName}
                              onChange={handleChange}
                            />
                          </div>
                        </div>

                        <div className="d-flex flex-row align-items-center mb-4">
                          <i className="fas fa-cat fa-lg me-3 fa-fw"></i>
                          <div className="form-outline flex-fill mb-0">
                            <input
                              type="text"
                              id="type"
                              name="type"
                              className="form-control"
                              placeholder="Type"
                              value={pet.type}
                              onChange={handleChange}
                            />
                          </div>
                        </div>

                        <div className="d-flex flex-row align-items-center mb-4">
                          <i class="fas fa-dog fa-lg me-3 fa-fw"></i>
                          <div className="form-outline flex-fill mb-0">
                            <input
                              type="text"
                              id="breed"
                              name="breed"
                              className="form-control"
                              placeholder="Breed"
                              value={pet.breed}
                              onChange={handleChange}
                            />
                          </div>
                        </div>

                        <div className="d-flex flex-row align-items-center mb-4">
                          <i class="fas fa-list-ol fa-lg me-3 fa-fw"></i>
                          <div className="form-outline flex-fill mb-0">
                            <input
                              type="number"
                              id="age"
                              name="age"
                              className="form-control"
                              placeholder="Age"
                              value={pet.age}
                              onChange={handleChange}
                            />
                          </div>
                        </div>

                        <div className="d-flex flex-row align-items-center mb-4">
                          <i class="fas fa-palette fa-lg me-3 fa-fw"></i>
                          <div className="form-outline flex-fill mb-0">
                            <input
                              type="text"
                              id="color"
                              name="color"
                              className="form-control"
                              placeholder="Color"
                              value={pet.color}
                              onChange={handleChange}
                            />
                          </div>
                        </div>

                        <div className="d-flex flex-row align-items-center mb-4">
                          <i className="fas fa-palette fa-lg me-3 fa-fw"></i>
                          <div className="form-outline flex-fill mb-0">
                            <input
                              type="text"
                              id="gender"
                              name="gender"
                              className="form-control"
                              placeholder="Gender"
                              value={pet.gender}
                              onChange={handleChange}
                            />
                          </div>
                        </div>
                        <div className="d-flex flex-row align-items-center mb-4">
                          <i className="fas fa-dollar-sign fa-lg me-3 fa-fw"></i>
                          <div className="form-outline flex-fill mb-0">
                            <input
                              type="number"
                              id="price"
                              name="price"
                              className="form-control"
                              placeholder="price"
                              value={pet.price}
                              onChange={handleChange}
                            />
                          </div>
                        </div>

                        <div className="d-flex flex-row align-items-center mb-4">
                          <i className="fas fa-hand-peace fa-lg me-3 fa-fw"></i>
                          <select
                            className="form-control"
                            name="status"
                            onChange={handleChange}
                            placeholder="status"
                            required
                          >
                            <option>Select the Status</option>
                            <option value="true">Available</option>
                            <option value="false">Out of Stock</option>
                          </select>
                        </div>

                        <div className="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
                          <button
                            type="submit"
                            className="btn btn-primary btn-lg"
                            onClick={handleSubmit}
                          >
                            Add Pet
                          </button>
                          <button
                            type="submit"
                            className="btn btn-primary btn-lg"
                          >
                            <Link to="/profile" className="text-white">
                              Profile
                            </Link>
                          </button>
                        </div>
                      </form>
                    </div>
                    <div className="col-md-10 col-lg-6 col-xl-5 d-flex align-items-center order-1 order-lg-2">
                      <img
                        src="https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/9aab9a1f-d227-4471-9f12-fa4a5b348f90/d3aq9rs-1f2f48c9-d089-40a2-b245-b60054cb9bb8.jpg/v1/fill/w_900,h_1313,q_75,strp/pet_stack_by_robthedoodler_d3aq9rs-fullview.jpg?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7ImhlaWdodCI6Ijw9MTMxMyIsInBhdGgiOiJcL2ZcLzlhYWI5YTFmLWQyMjctNDQ3MS05ZjEyLWZhNGE1YjM0OGY5MFwvZDNhcTlycy0xZjJmNDhjOS1kMDg5LTQwYTItYjI0NS1iNjAwNTRjYjliYjguanBnIiwid2lkdGgiOiI8PTkwMCJ9XV0sImF1ZCI6WyJ1cm46c2VydmljZTppbWFnZS5vcGVyYXRpb25zIl19.gmX2L-eLvNTJqupcJylhVOmZxCvyYqOghjHOS3SKWOY"
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
        <Bottom />
      </section>
    </>
  );
};

export default AddPet;
