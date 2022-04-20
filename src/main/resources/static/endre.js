$(() => {
    getSelectedRegistration()

    $("#change").on("click",() => {
        const ssn = $("#ssn");
        const name = $("#name");
        const address = $("#address");
        const characteristics = $("#characteristics");
        const brand = $("#chosenBrand");
        const type = $("#chosenType");

        const registration = {
            id: id,
            ssn: ssn.val(),
            name: name.val(),
            address: address.val(),
            characteristics: characteristics.val(),
            brand: brand.val(),
            type: type.val()
        };

        // dropper validering for neste uke
        $.post("/api/updateOneRegistration", registration, () => {
            window.location.href = "/";
        });
    })

});

const id = window.location.search.substring(1);

const getSelectedRegistration = () => {
    console.log(id)

    $.get("/api/registration?id=" + id, registration => {
        console.log(registration);
        $("#ssn").val(registration.ssn);
        $("#name").val(registration.name);
        $("#address").val(registration.address);
        $("#characteristics").val(registration.characteristics);
        $.ajaxSetup({async:false}); // need to make async so that get in onchange doesn't overwrite chosentype value setting
        $("#chosenBrand").val(registration.brand).change(); // disabled workaround, triggers change
        $.ajaxSetup({async:true});
        $("#chosenType").val(registration.type);
    });
};