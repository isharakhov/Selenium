import config.AvitoTestConfig;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.Test;
import page.AvitoPage;

/**
 * Основной класс с тестами AvitoPage
 */
@Epic("Поиск принтера во Владивостоке")
public class avitoTestTask extends ParentTest {

    /**
     * Экземпляр конфигурации с параметрами для Avito тестов
     */
    private final AvitoTestConfig config = ConfigFactory.create(AvitoTestConfig.class, System.getenv());

    @Feature("Вывод результатов поиска цен")
    @Test(description = "Вывод первых 5 цен поиска в консоль")
    public void testAvitoFiveFirstPrises() {

        new AvitoPage(driver).clickToCategory()    //нажимаем на выпадающий окно с категориями
                .clickToCategoryOrgtehnika()   //выбор категории
                .inputStringInSearchFieldItem(config.inputSearchItem())    //вводим Принтер
                .clickToAreaSearch()           //открытие поля поиска по городу
                .clickToDeepFieldAreaSearch()  //поле поиска по городам
                .inputStringInSearchFieldCity(config.inputSearchCity())   //вводим Владивосток
                .clickBigButtonForFoundedItems()     //нажимаем на кнопку поиска
                .clickCheckBox()     //чек-бокс только с фото
                .clickSelectorByPrice()    //Выпадающий список
                .clickExpensive()  //Выбираем Дороже
                .printFirstPriseByNumber(5); //Выводим первые 5 цен в консоль
    }
}