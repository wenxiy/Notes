/**
 * 饿汉式单例模式
 * 原则：在单例模式的定义中产生：在新建对象的时候，希望在堆的内存空间中，只有一个对象
 */
public class single {
    private static final single Instance = new single();//这个表示 这个Instance必须要在类加载之前就完成，并且不可改变，
    // 而且这个为private是为了只能在这个类中new，不能再其他地方new

    /**
     * 下面这个方法，说明了我们要在其他类中不能new我这个类，只能通过调用这个getInstance来进行用
     * 所以是public，static表示必须在类之前加载
     *
     * @return
     */
    public static single getInstance() {
        return Instance;
    }
}

/**
 * 因为饿汉式在没有用到Instance的时候就已经new了，所以会消耗一定的资源
 * 所以发现了以下的方法,当我们有需要调用Instance的时候，我们判断以下是否有这个Instance，没有的话我们在进行一个new
 * 但是在这种方式里面，我的Instance是线程不安全的，为什么？因为对于多线程来说，当一个线程判断了是否为空，另一个线程过来也判断，导致会new两个对象
 * 那么解决方法就是加锁
 */
class singles {
    private static singles Instance;

    public static singles getInstance() {
        if (Instance == null) {
            Instance = new singles();
        }
        return Instance;
    }

}

/**
 * 直接在getInstance方法中直接加锁，虽然解决了线程安全的问题，但是如果我们有一些耗时操作需要在getInstance中执行，那么我们的这个锁的力度太大了
 * 所以我们采取将锁的力度变小，只锁这个class的对象
 */
class singless {
    private singless() {

    }

    private static singless Instance;

    public synchronized static singless getInstance() {
        if (Instance == null) {
            Instance = new singless();
        }
        return Instance;
    }
}

/**
 * 但是我们发现，这种方法也不能对多线程进行访问安全，当第一个线程完成了这个任务释放了锁，但是由于第二个线程已经进判断空的条件里，所以还会new一个对象
 * 所以我们检查两遍，DCL最终的方法实现单例模式
 */
class singlesss {
    private singlesss() {

    }

    private static singlesss Instance;

    public static singlesss getInstance() {
        synchronized (singlesss.class) {
            Instance = new singlesss();
        }
        return Instance;
    }
}

/**
 * 这种方法DCL中，我们通过这个方法从而实现了一个线程安全，并且达到了单例的模式，也对内存进行了优化
 * 但是，这种办法又有一个缺点：如果指令重排序了，那么我使用的单例是一个半初始化的对象（也就是我使用的对象，是付给了默认值的对象，而不是调用构造
 * 方法的对象。
 * 我们在这里要先说一下对象的new过程：一个对象，new的时候，先在堆内存中开辟空间，再对这个对象进行调用构造方法，最后定义引用指向这个空间
 * 但是，指令重排序原则是说，当我的CPU运算很快，内存很慢，我为了平衡这个点，我其实一般是先开辟空间，再指向这个空间，最后再调用构造方法（
 * 因为调用构造函数这个方法很费时，内存算不过来，CPU又不能干等结果，所以就造成了这样的情况）
 * 所以我们要在单例的时候干嘛，要禁止指令重排序。因为在指令重排序的时候，对于多线程的单例模式来说，当如果一个线程new的时候，发生了重排序，
 * 然后第二个线程来的时候，判断了不为空，在第二个线程里用的是半初始化的对象，也就是采用默认值的对象，而不是调用了构造方法的对象。
 * 所以为了避免这种状况，我们需要采用了volatile来修饰
 */
class singledcl {
    private singledcl() {
    }

    private static singledcl Instance;

    public static singledcl getInstance() {
        if (Instance == null) {
            synchronized (singledcl.class) {
                if (Instance == null) {
                    Instance = new singledcl();
                }
            }
        }
        return Instance;
    }
}

class singledclv {
    private singledclv() {

    }

    private volatile static singledclv Instance;

    public static singledclv getInstance() {
        if (Instance == null) {
            synchronized (singledclv.class) {
                if (Instance == null) {
                    Instance = new singledclv();
                }

            }
        }
        return Instance;
    }

}