productSorter = {
    sendToIndex : function(data) {
        $.post("/", data);
    },

    initDropDownCategory : function() {
        let categories = document.querySelectorAll(".category");
        for (let category of categories) {
            category.addEventListener("click", function() {
                let categoryName = category.dataset.categoryName;
                let data = {"categoryName":categoryName};
                productSorter.sendToIndex(data);
            })
        }
    },

    initDropDownSupplier : function() {
        let suppliers = document.querySelectorAll(".supplier");
        for (let supplier of suppliers) {
            supplier.addEventListener("click", function() {
                let supplierName = supplier.dataset.supplierName;
                let data = {"supplierName":supplierName};
                productSorter.sendToIndex(data);
            })
        }
    }

};