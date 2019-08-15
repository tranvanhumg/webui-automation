package vn.amabuy.features.function;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.SoftAssertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;
import net.thucydides.core.util.EnvironmentVariables;
import vn.amabuy.properties.MyProperties;

@RunWith(SerenityRunner.class)
@WithTags(
{
	@WithTag("EnviromentVariable")
})
public class WhenCheckSerenityProperties {
		
	private EnvironmentVariables enviroment;
	private String myProperties_fullname;
	private String myProperties_email;
	
	//get properties test by soft assert
	
	@Before
	public void getSerenityProperties()
	{		
		myProperties_fullname = enviroment.optionalProperty(MyProperties.FULLNAME).orElse("Tran Thi Van");
		System.out.print(myProperties_fullname+"-------------------\n");
		myProperties_email = enviroment.optionalProperty(MyProperties.EMAIL).orElse("tranvan@gmail.com");
		System.out.print(myProperties_email+"-------------------\n");
	}
	
	@Test
	public void assert_softassertj()
	{		
		SoftAssertions soft=new SoftAssertions();
		soft.assertThat("Tran Thi Van").isEqualTo(myProperties_fullname);
		soft.assertThat("Tran Thi").isEqualTo(myProperties_fullname);
		soft.assertThat("Tran Van").isEqualTo(myProperties_fullname);
		soft.assertAll();
	}
}
