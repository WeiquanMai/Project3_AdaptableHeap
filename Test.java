/******************************************
 *  @Author : Ali Azhari   
 *  Created On : Oct 23 2025
 *  @File : Test.java
 *  Description: Testing Adaptable PQ ADT
 *******************************************/
/**
 *   TERMS AND CONDITIONS FOR USE, REPRODUCTION, AND DISTRIBUTION
 *
 *   THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *   IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 *   FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.  IN NO EVENT SHALL THE
 *   CONTRIBUTORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *   LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *   OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS WITH THE
 *   SOFTWARE.
 */


public class Test {

    public static void main(String[] args) {

        HeapAdaptablePriorityQueue<Integer, String> apq = new HeapAdaptablePriorityQueue<>();

        apq.insert(5, "A");
        apq.insert(9, "B");
        apq.insert(7, "C");
        apq.insert(1, "D");
        apq.insert(3, "E");
        apq.insert(6, "F");
        System.out.println("Size of the heap: " + apq.size());
        System.out.println("Minimum element in the heap: " + apq.min().getValue());
        Entry<Integer, String> removed = apq.removeMin();
        System.out.println("Removed element: " + removed.getValue());
        System.out.println("New minimum element in the heap: " + apq.min().getValue());

        Entry<Integer, String> entry = apq.insert(2, "G");

        System.out.println("New minimum element in the heap: " + apq.min().getValue());

        apq.replaceKey(entry, 10);

        // My test code
        System.out.println("New minimum element after changing key: " + apq.min().getValue());
        apq.replaceKey(entry, 2);
        System.out.println("New minimum element after changing entry of G to 2: " + apq.min().getValue());
        apq.remove(entry);
        System.out.println("Minimum value after removing G: " + apq.min().getValue());
        Entry<Integer, String> entry1 = apq.insert(1, "A");
        System.out.println("New minimum value " + apq.min().getValue());
        apq.replaceValue(entry1, "Z");
        System.out.println("New minimum value " + apq.min().getValue());
    }
}
