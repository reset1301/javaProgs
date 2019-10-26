requirejs.config({
    baseUrl: "js"
});

function buildRoute(view) {
    return function () {
        webix.ui({
            id: 'root',
            rows: [
                view
            ]
        }, $$('root'))
    };
}

require(['views/main', 'views/cars'], function (main, cars) {
    webix.ready(function () {
        webix.ui({
            // id: "root",
            container: "app"//,
            // rows: [
            //     main
            // ]
        })
    });

    routie({
        '': buildRoute(main),
        'cars': buildRoute(cars)
    })
});