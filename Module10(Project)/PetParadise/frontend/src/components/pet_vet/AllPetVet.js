import { Link } from "react-router-dom";
import AllPetVetCards from "./AllPetVetCards";
import Bottom from "../Bottom";
const AllPetVet = () => {
  return (
    <>
      <div>
        <h1 className="mb-3"> Veterinary</h1>
      </div>
      <button type="button" class="btn btn-dark mb-3">
        <Link to="/saveveterinary">Register As Veterinary</Link>
      </button>
      <div>
        <AllPetVetCards />
      </div>

      <Bottom />
    </>
  );
};

export default AllPetVet;
