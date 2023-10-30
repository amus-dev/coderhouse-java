import { Link } from "react-router-dom";
import "./styles.cardproduct.css";
import Button from "../../molecules/Button";
import { BASE_URL_API } from "../../../config/index";

const CardProduct = ({ product }) => {
  const handleClickDelete = () => {
    const response = confirm("¿Estas seguro de eliminar este producto?");
    if (response) {
      fetch(`${BASE_URL_API}/producto/eliminar/${product.id}`, {
        method: "GET", // or 'PUT'
      })
        .then(() => {
          alert("ELiminado con exito");
          window.location.reload();
        })
        .catch((error) => console.error("Error:", error))
        .then((response) => console.log("Success:", response));
    }
  };

  return (
    <div className="cardProduct">
      <div className="cardProduct__body">
        <img
          src={product.imagePath}
          className="cardProduct__body-image"
          alt="Tomaticán - platos congelados"
        />
        <h5 className="cardProduct__body-title raleway">{product.nombre}</h5>
        <p className="cardProduct__body-description raleway">
          {product.descripcion}
        </p>
        <p className="cardProduct__body-price raleway">{product.precio}</p>
        <Link
          className="cardProduct__body-button button-editar raleway"
          to={`/edit/${product.id}`}
        >
          Editar
        </Link>
        <Button
          className="button-eliminar"
          text="Eliminar"
          onClick={handleClickDelete}
        />
      </div>
    </div>
  );
};

export default CardProduct;
