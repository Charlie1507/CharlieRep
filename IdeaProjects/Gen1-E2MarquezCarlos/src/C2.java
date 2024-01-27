import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class C2
{
    public static void main(String[] args)
    {
        Map<String, ArrayList<String>> categorias = new HashMap<>();


        categorias.put("Vinos y licores", new ArrayList<>());
        categorias.put("Carnes frías", new ArrayList<>());
        categorias.put("Blancos", new ArrayList<>());

        
        categorias.get("Carnes frías").add("Salchichas");
        categorias.get("Carnes frías").add("Jamón");
        categorias.get("Carnes frías").add("Queso");
        categorias.get("Carnes frías").add("Salami");

        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("Menú:");
            System.out.println("1. Mostrar Categorías");
            System.out.println("2. Mostrar productos por categoría");
            System.out.println("3. Agregar categoría");
            System.out.println("4. Agregar producto a una categoría");
            System.out.println("5. Salir");

            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion)
            {
                case 1:
                    System.out.println("Categorías disponibles:");
                    for (String categoria : categorias.keySet())
                    {
                        System.out.println(categoria);
                    }
                    break;
                case 2:
                    System.out.print("Ingrese la categoría: ");
                    String categoriaSeleccionada = scanner.nextLine();
                    if (categorias.containsKey(categoriaSeleccionada))
                    {
                        System.out.println("Productos en " + categoriaSeleccionada + ":");
                        for (String producto : categorias.get(categoriaSeleccionada))
                        {
                            System.out.println(producto);
                        }
                    }
                    else
                    {
                        System.out.println("La categoría no existe.");
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el nombre de la nueva categoría: ");
                    String nuevaCategoria = scanner.nextLine();
                    categorias.put(nuevaCategoria, new ArrayList<>());
                    System.out.println("Categoría agregada correctamente.");
                    break;
                case 4:
                    System.out.print("Ingrese la categoría a la que desea agregar un producto: ");
                    String categoriaAgregarProducto = scanner.nextLine();

                    if (categorias.containsKey(categoriaAgregarProducto))
                    {
                        System.out.print("Ingrese el nombre del producto: ");
                        String nuevoProducto = scanner.nextLine();
                        categorias.get(categoriaAgregarProducto).add(nuevoProducto);
                        System.out.println("Producto agregado correctamente a " + categoriaAgregarProducto + ".");
                    }
                    else
                    {
                        System.out.println("La categoría no existe.");
                    }
                    break;
                case 5:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }

        } while (opcion != 5);
    }
}
