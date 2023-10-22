import { Link } from "react-router-dom";
import "./styles.cardproduct.css";
import Button from "../../molecules/Button";

const CardProduct = () => {
  const handleClickDelete = () => {
    const response = confirm("¿Estas seguro de eliminar este producto?");
    if (response) {
      console.log("Si, estoy seguro");
    } else {
      console.log("No, no estoy seguro");
    }
  };

  return (
    <div className="cardProduct">
      <div className="cardProduct__body">
        <img
          src="https://i0.wp.com/platoslistos.cl/wp-content/uploads/2020/10/PASTEL-DE-CHOCLO-CON-CARNE-WEB-1.jpg"
          className="cardProduct__body-image"
          alt="Tomaticán - platos congelados"
        />
        <h5 className="cardProduct__body-title raleway">Pastel de Choclo</h5>
        <p className="cardProduct__body-description raleway">
          Carne sin grasa y el corte es perfecto, la salsa lo acompaña muy bien,
          acompañalo con arroz blanco
        </p>
        <p className="cardProduct__body-price raleway">$4.590</p>
        <Link
          className="cardProduct__body-button button-editar raleway"
          to={`/edit/${1}`}
        >
          Editar
        </Link>
        <Button text="Eliminar" onClick={handleClickDelete} />
      </div>
    </div>
  );
};

export default CardProduct;
