import CardProduct from "../../organism/CardProduct";

const HomeTemplate = () => {
  return (
    <div>
      <h1 className="title color-blue">Comida congelada a domicilio</h1>
      <p className="description color-orange">
        Platos de primera, cocinados de manera artesanal con productos
        seleccionados, sin aditivos ni conservantes. Recibe nuestra comida
        directamente en tu casa. ¡Garantía de calidad!
      </p>
      <div className="row">
        <CardProduct />
        <CardProduct />
        <CardProduct />
        <CardProduct />
        <CardProduct />
        <CardProduct />
        <CardProduct />
        <CardProduct />
      </div>
    </div>
  );
};

export default HomeTemplate;
