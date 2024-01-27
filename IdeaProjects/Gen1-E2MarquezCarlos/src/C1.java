import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C1
{
    public static void main(String[] args)
    {
        int opc=0;
        int opcs=0;
        int sublong;
        //String nuevac = null;
        Scanner s = new Scanner(System.in);
        List<List<String>> categoria = new ArrayList<>();
        List<String> categorianom = new ArrayList<>();
        List<String> vinos = new ArrayList<>();
        List<String> carnes = new ArrayList<>();
        List<String> blancos = new ArrayList<>();
        categorianom.add("Vinos y licores");
        categorianom.add("Carnes frias");
        categorianom.add("Blancos");
        categoria.add(categorianom);
        categoria.add(vinos);
        categoria.add(carnes);
        categoria.add(blancos);
        carnes.add("Salchicha");
        carnes.add("Jamon");
        carnes.add("Queso");
        carnes.add("Salami");

        int lon;



        while(opc!=5)
        {
            System.out.println("Menu:");
            System.out.println("1) Mostrar Categorias");
            System.out.println("2) Mostrar Productos por categoria");
            System.out.println("3) Agregar Categoria");
            System.out.println("4) Agregar Producto a una categoria");
            System.out.println("5) Salir");
            System.out.print("Elige la opcion deseada: ");
            opc = s.nextInt();


            switch (opc)
            {
                case 1:
                    //Actualiza la longitud de la lista
                    lon=categorianom.size();

                    //Imprime la lista de nombres de las categorias
                    for (int i = 0; i < lon; i++)
                    {
                        System.out.println((i+1) + ") " + categorianom.get(i));
                    }
                    break;

                case 2:
                    //Actualiza la longitud de la lista
                    lon= categorianom.size();


                    while(opcs!=1)
                    {
                        //Imprime los nombres de las categorias
                        for (int i = 0; i < lon; i++)
                        {
                            System.out.println((i+1) + ") " + categorianom.get(i));
                        }

                        //Ingresa el valor deseado de la categoria a consultar
                        System.out.print("Selecciona la categoria deseada: ");
                        opcs = s.nextInt();

                        //Valida si la opcion es valida y en caso de no serlo solicitarla nuevamente
                        if (opcs <= 0 || opcs > lon)
                        {
                            System.out.println("Seleccione una opcion valida");
                        }
                        else
                        {
                            //Verifica si hay elementos en la categoria a consultar
                            sublong = categoria.get(opcs).size();

                            //En caso de que no haya elementos arroja un mensaje de que no los hay
                            if (sublong == 0)
                            {
                                System.out.println("No se encuentran elementos en esta categoria");
                            }

                            //En caso de haber elementos los imprime
                            else
                            {
                                for (int j = 0; j < sublong; j++)
                                {
                                    System.out.println(categoria.get(opcs).get(j));
                                }
                                opcs = 1;
                            }
                        }

                    }
                    opcs=0;
                    break;

                case 3:

                    //Solicita el nombre de la categoria
                    System.out.print("Digite el nombre de la nueva categoria: ");
                    String nuevac=s.next();
                    categorianom.add(nuevac);

                    //Crea una lista de manera temporal y la guarda en la lista de categorias
                    List<String> productosn = new ArrayList<>();
                    categoria.add(productosn);

                    //nuevac=null;
                    opc=0;
                    break;

                case 4:

                    lon=categorianom.size();
                    
                    while(opcs!=1)
                    {
                        for (int i = 0; i < lon; i++)
                        {
                            System.out.println((i+1) + ") " + categorianom.get(i));
                        }
                        System.out.print("Selecciona la categoria donde desea agregar el elemento: ");
                        opcs = s.nextInt();
                        if (opcs <= 0 || opcs > lon)
                        {
                            System.out.println("Seleccione una opcion valida");
                        }
                        else
                        {
                            System.out.print("Ingrese el nombre del nuevo producto: ");
                            String nomvar = s.next();

                            categoria.get(opcs).add(nomvar);

                            System.out.println("Producto agregado correctamente");

                            opcs=0;
                        }
                    }
                    opcs=0;
                    opc=0;
                    break;

                case 5:

                    break;

                default:
                    System.out.println("selecciona una respuesta correcta");
                    break;
            }
        }

        //System.out.println(categoria);

    }
}
