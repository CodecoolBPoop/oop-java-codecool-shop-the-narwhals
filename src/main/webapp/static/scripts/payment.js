payment = {
    cardNumberModifier: function(){
        $('#cardNumber').keyup(function() {
            $(this).val($(this).val().replace(/(\d{4})(\d+)/g, '$1-$2'))
        });
    }
};

payment.cardNumberModifier();