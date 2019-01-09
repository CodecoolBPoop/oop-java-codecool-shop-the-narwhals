itemCollector = {
    sendToCart : function() {
        let info = {};
        $.post("/cart", info);
    },

    initAddButtons : function() {
        let addButtons = document.querySelectorAll(".add-to-cart");
        for (let button of addButtons) {
            button.addEventListener("click", function() {
                itemCollector.sendToCart();
            })
        }
    }

}