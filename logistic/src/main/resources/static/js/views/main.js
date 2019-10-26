define(function () {
    return {
        type: "line",
        height: 400,
        rows: [
            {
                view: "button",
                label: "Cars",
                click: function () {
                    routie('cars')
                }
            },
            {template: "Row1"},
            {template: "Row2"},
            {
                cols: [
                    {template: "Col1"},
                    {template: "Col2"}

                ]
            }
        ]
    }
});