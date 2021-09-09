const agregarButton = document.querySelectorAll('.carrito__add-quantity');
const eliminarButton = document.querySelectorAll('.carrito__substract-quantity');

agregarButton.forEach(button => {
  button.addEventListener( 'click', () =>{
    let quantity = button.parentNode.querySelector('.quantity').textContent;
    quantity= parseInt(quantity) + 1;
    const number = button.parentNode.querySelector('.quantity');
    number.innerText=`${quantity}`;
  } )
});

eliminarButton.forEach(button => {
  button.addEventListener( 'click', () =>{
    let quantity = button.parentNode.querySelector('.quantity').textContent;
    quantity = parseInt(quantity) - 1;
    const number = button.parentNode.querySelector('.quantity');
    number.innerText=`${quantity}`;
  } )
});