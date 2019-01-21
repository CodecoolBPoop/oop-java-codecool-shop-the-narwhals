filter = {
    changeDropdownButton: function (button, value, id) {
        button.innerText = value;
        button.dataset.selectedId = id;
    },

    doFilter: function (categoryButton, supplierButton) {
        let link = "/";
        if (categoryButton.dataset.selectedId) {
            link = link + "?category=" + categoryButton.dataset.selectedId;

            if (supplierButton.dataset.selectedId) {
                link = link + "&supplier=" + supplierButton.dataset.selectedId;
            }
        } else if (supplierButton.dataset.selectedId) {
            link = link + "?supplier=" + supplierButton.dataset.selectedId;
        }

        window.location = link;
    },

    initFilterButton: function () {
        let filterButton = document.querySelector("#filter-button");
        let categoryButton = document.querySelector("#category-filter-button");
        let supplierButton = document.querySelector("#supplier-filter-button");
        filterButton.addEventListener("click", function () {
            filter.doFilter(categoryButton, supplierButton)
        })
    },

    initDropdownItems: function () {
        let dropdownItems = document.querySelectorAll(".dropdown-item");
        for (let item of dropdownItems) {
            let dropdownButton = document.querySelector("#" + item.dataset.filterType + "-filter-button");
            item.addEventListener("click", function () {
                filter.changeDropdownButton(dropdownButton, item.innerText, item.dataset.id)
            })
        }
    }
};