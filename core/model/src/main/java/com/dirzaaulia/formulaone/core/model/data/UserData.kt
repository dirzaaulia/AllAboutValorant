import com.dirzaaulia.formulaone.core.model.data.DarkThemeConfig
import com.dirzaaulia.formulaone.core.model.data.ThemeBrand

/**
 * Class summarizing user interest data
 */
data class UserData(
    val themeBrand: ThemeBrand,
    val darkThemeConfig: DarkThemeConfig,
    val useDynamicColor: Boolean,
    val shouldHideOnboarding: Boolean,
)
