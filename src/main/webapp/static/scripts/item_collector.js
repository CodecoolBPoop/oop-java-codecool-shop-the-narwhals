itemCollector = {
    sendToCart : function(productId) {
        let info = {"productId": productId};
        $.post("/cart", info);
    },

    initAddButtons : function() {
        let addButtons = document.querySelectorAll(".add-to-cart");
        for (let button of addButtons) {
            let productId = button.dataset.productId;
            button.addEventListener("click", function() {
                itemCollector.sendToCart(productId);
            })
        }
    }

};