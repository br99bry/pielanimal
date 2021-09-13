const productsCart = document.querySelectorAll('.carrito-product');

const calSubTotal = () => {
  const subTotalBox = document.getElementById('subtotal');
  const items = document.querySelectorAll('.carrito__items-total p i');
  let subTotal = 0;
  items.forEach( item => {
    subTotal+= parseFloat(item.innerText);
  } )
  subTotalBox.innerText=`${subTotal}`
}

const calcItems = (product) => {
  const quantityManage = product.querySelector('.quantity');
  let quantity = parseInt(quantityManage.innerText);
  const unitPriceBox = product.querySelector('.carrito__items-precio p i');
  const unitPrice = parseFloat(unitPriceBox.innerText);
  const quantityPriceBox = product.querySelector('.carrito__items-total p i');
  let quantityPrice = unitPrice * quantity;
  quantityPriceBox.innerText=`${quantityPrice}`
  calSubTotal();
}


productsCart.forEach(product => {
  calcItems(product);
  const button = product.querySelector('.carrito__add-quantity');
  button.addEventListener( 'click', () =>{
    let quantity = button.parentNode.querySelector('.quantity').innerText;
    quantity = parseInt(quantity) + 1;
    const number = button.parentNode.querySelector('.quantity');
    number.innerText=`${quantity}`;
    calcItems(product);
  } )
});

productsCart.forEach(product => {
  const button = product.querySelector('.carrito__substract-quantity');
  calcItems(product);
  button.addEventListener( 'click', () =>{
    let quantity = button.parentNode.querySelector('.quantity').innerText;
    if(quantity!=1){
      quantity = parseInt(quantity) - 1;
    }
    const number = button.parentNode.querySelector('.quantity');
    number.innerText=`${quantity}`;
    calcItems(product);
  } )
});