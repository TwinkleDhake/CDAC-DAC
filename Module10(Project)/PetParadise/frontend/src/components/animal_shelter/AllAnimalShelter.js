import AnimalShelterCards from "./AnimalShelterCards";
import { Link } from "react-router-dom";
import Bottom from "../Bottom";

const AllAnimalShelter = () => {
  return (
    <>
      <div>
        <h1 className="mb-3"> Animal Shelter</h1>
      </div>
      <button type="button" class="btn btn-dark mb-3">
        <Link to="/saveanimalshelter">Register As Animal Shelter</Link>
      </button>
      <br/>
      <hr/>
      <div>
        <AnimalShelterCards />
        <hr/>
      </div>
      <hr/>
      <Bottom />
    </>
  );
};

export default AllAnimalShelter;
