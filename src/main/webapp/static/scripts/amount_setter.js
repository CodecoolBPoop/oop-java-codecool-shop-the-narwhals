amountSetter = {
    handleChange: function (number, numberContainer, priceContainer) {
        if (number <= 0) {
            let rowToDelete = numberContainer.closest(".row");
            rowToDelete.parentNode.removeChild(rowToDelete);
        } else {
            numberContainer.innerText = number;
            let unitPrice = parseFloat(priceContainer.dataset.unitPrice);
            priceContainer.innerText = Number(unitPrice * number).toFixed(2);
        }

        amountSetter.setOrderTotal();
    },

    setOrderTotal: function () {
        let sum = 0;
        let priceElements = document.querySelectorAll(".lineitem-price");
        for (let element of priceElements) {
            sum += parseFloat(element.innerText);
        }

        let totalPriceContainer = document.querySelector("#order-total-span");
        totalPriceContainer.innerText = Number(sum).toFixed(2);
    },

    handleClick: function (button) {
        let infoNode = $(button.parentNode.parentNode)[0];
        let productId = infoNode.dataset.productId;
        let change = parseInt(button.dataset.change);
        let numberContainer = $(infoNode).find(".amount-number")[0];
        let priceContainer = document.querySelector("#product-" + productId + "-price");

        let dataToSend = {"productId": productId, "change": change};
        $.ajax({
            url: "/cart",
            type: "PUT",
            data: dataToSend,
            success: function (data) {
                let jsonData = JSON.parse(data);
                amountSetter.handleChange(jsonData["numberOfProducts"], numberContainer, priceContainer)
            }
        })
    }
    ,

    initAmountButtons: function () {
        let amountButtons = document.querySelectorAll(".amount-button");
        for (let button of amountButtons) {
            button.addEventListener("click", function () {
                amountSetter.handleClick(button);
            })
        }
    }
}
;

amountSetter.initAmountButtons();