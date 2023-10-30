import CardProduct from "../../organism/CardProduct";

const HomeTemplate = ({ products }) => {
  return (
    <div>
      <h1 className="title color-blue">Comida congelada a domicilio</h1>
      <p className="description color-orange">
        Platos de primera, cocinados de manera artesanal con productos
        seleccionados, sin aditivos ni conservantes. Recibe nuestra comida
        directamente en tu casa. ¡Garantía de calidad!
      </p>
      <div className="row">
        {products &&
          products.map((product) => (
            <CardProduct key={product.id} product={product} />
          ))}
      </div>
    </div>
  );
};

export default HomeTemplate;
