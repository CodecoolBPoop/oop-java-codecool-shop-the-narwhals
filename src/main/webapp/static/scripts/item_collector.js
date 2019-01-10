itemCollector = {
    sendToCart : function(productId, callback) {
        let info = {"productId": productId};
        $.post("/cart", info, function(data) {
            callback(JSON.parse(data)["numberOfItemsInCart"]);
        });
    },

    initAddButtons : function() {
        let addButtons = document.querySelectorAll(".add-to-cart");
        for (let button of addButtons) {
            let productId = button.dataset.productId;
            button.addEventListener("click", function() {
                itemCollector.sendToCart(productId, itemCollector.displayNumberOfItems);
            })
        }
    },

    displayNumberOfItems : function (number) {
        let placeForNumber = document.querySelector("#number-of-items-in-cart");
        placeForNumber.innerText = number;
    }


};