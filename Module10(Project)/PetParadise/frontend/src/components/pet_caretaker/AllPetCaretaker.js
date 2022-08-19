import PetCareTakerCards from "./PetCareTakerCards";
import { Link } from "react-router-dom";
import Bottom from "../Bottom";

const AllPetCaretaker = () => {
  return (
    <>
      <div>
        <h1 className="mb-3">Pet Caretakers</h1>
      </div>
      <button type="button" class="btn btn-dark mb-3">
        <Link to="/savepetcaretaker">Register As Pet Caretakers</Link>
      </button>
      <div>
        <PetCareTakerCards />
      </div>
      <Bottom />
    </>
  );
};

export default AllPetCaretaker;
