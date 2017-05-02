
<div ng-controller="templateController">
    <table>
        <tbody>
        <tr>
            <td><image src="/libros/{{parameter.id}}/picture" alt="" width="60" height="80"/></td>

        </tr>
        <tr>
            <td id="nombreMa">
                Nombre:    {{parameter.nombre}}
            </td>

        </tr>
        <tr>
            <td>
                Editorial: {{parameter.editorial}}
            </td>
        </tr>
        <tr>
            <td>
                Autor:     {{parameter.autor}}
            </td>
        </tr>
        <tr>
        <td><button class="btn btn-default" ng-click="showConfirm(todo)">Intercambiar Libro</button></td>
        </tr>
        </tbody>
    </table>
</div>