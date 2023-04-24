package test;

import static org.junit.jupiter.api.Assertions.*;

import data_structure.model.HashTable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class HashTableTest {

    @Test
    public void testInsert() { //** Probamos la función insert, insertando clave-valor */

        HashTable<Integer, String> table = new HashTable<>(10);

        table.insert(1, "Uno");
        table.insert(2, "Dos");
        table.insert(3, "Tres");

        assertEquals("Uno", table.get(1)); //** comprobamos que se recuperan... */
        assertEquals("Dos", table.get(2)); //** los valores correspondientes mediante el get */
        assertEquals("Tres", table.get(3));
    }

    @Test
    public void testGet() { //** también probamos el get, pero en este caso insertamos valor-clave */
        HashTable<String, Integer> table = new HashTable<>(5);

        table.insert("uno", 1);
        table.insert("dos", 2);
        table.insert("tres", 3);

        assertEquals(1, (int) table.get("uno")); //** se comprueba que se puedan recuperar los valores */
        assertEquals(2, (int) table.get("dos")); //** utilizando las claves correspondientes  */
        assertEquals(3, (int) table.get("tres"));
    }

    @Test
    public void testRemove() { //** probamos el remove  insertando clave-valor*/
        HashTable<String, Integer> table = new HashTable<>(5);

        table.insert("uno", 1);
        table.insert("dos", 2);
        table.insert("tres", 3);

        table.remove("uno"); //** se elimina */

        assertNull(table.get("uno")); //** validamos que ya no se encuentra */
        assertEquals(2, (int) table.get("dos"));
        assertEquals(3, (int) table.get("tres"));
    }

    @Test
    public void testHash() { //testeamos el método hash
        HashTable<Integer, String> table = new HashTable<>(10);

        // Verificar que los hashes para varias claves sean distintos
        int hash1 = table.hash(1);
        int hash2 = table.hash(2);
        int hash3 = table.hash(3);
        int hash4 = table.hash(4);

        assertNotEquals(hash1, hash2);
        assertNotEquals(hash2, hash3);
        assertNotEquals(hash3, hash4);
        assertNotEquals(hash4, hash1);

        // Verificar que el hash de la misma clave sea consistente
        int hash5 = table.hash(5);
        int hash6 = table.hash(5);

        assertEquals(hash5, hash6);
    }





}
