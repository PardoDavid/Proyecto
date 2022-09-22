/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var boton = document.getElementById('botonmodel');
var caja = document.getElementById('model');

boton.addEventListener('click', function()
{
    caja.classList.replace("model","modelactivo");
});

