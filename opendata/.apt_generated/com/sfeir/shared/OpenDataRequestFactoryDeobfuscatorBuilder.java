// Automatically Generated -- DO NOT EDIT
// com.sfeir.shared.OpenDataRequestFactory
package com.sfeir.shared;
import java.util.Arrays;
import com.google.web.bindery.requestfactory.vm.impl.OperationData;
import com.google.web.bindery.requestfactory.vm.impl.OperationKey;
public final class OpenDataRequestFactoryDeobfuscatorBuilder extends com.google.web.bindery.requestfactory.vm.impl.Deobfuscator.Builder {
{
withOperation(new OperationKey("XaSR4gz$B0zeLL6ERSDFGMFaj4o="),
  new OperationData.Builder()
  .withClientMethodDescriptor("(II)Lcom/google/web/bindery/requestfactory/shared/Request;")
  .withDomainMethodDescriptor("(II)Ljava/util/List;")
  .withMethodName("findVilles")
  .withRequestContext("com.sfeir.shared.VilleRequest")
  .build());
withOperation(new OperationKey("EQVulLp_rBcyeRmx1un58NHuzss="),
  new OperationData.Builder()
  .withClientMethodDescriptor("()Lcom/google/web/bindery/requestfactory/shared/Request;")
  .withDomainMethodDescriptor("()Ljava/util/List;")
  .withMethodName("findAllVilles")
  .withRequestContext("com.sfeir.shared.VilleRequest")
  .build());
withOperation(new OperationKey("O69pvPmlZqKqUPMylM0BZgryuN4="),
  new OperationData.Builder()
  .withClientMethodDescriptor("(Ljava/lang/String;)Lcom/google/web/bindery/requestfactory/shared/Request;")
  .withDomainMethodDescriptor("(Ljava/lang/String;)Ljava/util/List;")
  .withMethodName("findVillesByDepartId")
  .withRequestContext("com.sfeir.shared.VilleRequest")
  .build());
withOperation(new OperationKey("2rRtYQBcpl3wZjJOjvY3t08wLz0="),
  new OperationData.Builder()
  .withClientMethodDescriptor("()Lcom/google/web/bindery/requestfactory/shared/Request;")
  .withDomainMethodDescriptor("()Ljava/util/List;")
  .withMethodName("findAllRegions")
  .withRequestContext("com.sfeir.shared.RegionRequest")
  .build());
withOperation(new OperationKey("ROM4bj3NbmwSTKCo9uowGlE2xdA="),
  new OperationData.Builder()
  .withClientMethodDescriptor("(II)Lcom/google/web/bindery/requestfactory/shared/Request;")
  .withDomainMethodDescriptor("(II)Ljava/util/List;")
  .withMethodName("findRegions")
  .withRequestContext("com.sfeir.shared.RegionRequest")
  .build());
withOperation(new OperationKey("mPra6J8ERgoGBkkSwJ4QwEjXMRI="),
  new OperationData.Builder()
  .withClientMethodDescriptor("()Lcom/google/web/bindery/requestfactory/shared/Request;")
  .withDomainMethodDescriptor("()Ljava/util/List;")
  .withMethodName("findAllDeparts")
  .withRequestContext("com.sfeir.shared.DepartRequest")
  .build());
withOperation(new OperationKey("F4pk6MTp9C8VuvX4xziztZk7lcw="),
  new OperationData.Builder()
  .withClientMethodDescriptor("(II)Lcom/google/web/bindery/requestfactory/shared/Request;")
  .withDomainMethodDescriptor("(II)Ljava/util/List;")
  .withMethodName("findDeparts")
  .withRequestContext("com.sfeir.shared.DepartRequest")
  .build());
withOperation(new OperationKey("LGMoVf1MMJMzf6u8FIS3gYvADbk="),
  new OperationData.Builder()
  .withClientMethodDescriptor("(Ljava/lang/String;)Lcom/google/web/bindery/requestfactory/shared/Request;")
  .withDomainMethodDescriptor("(Ljava/lang/String;)Ljava/util/List;")
  .withMethodName("findDepartsByRegionId")
  .withRequestContext("com.sfeir.shared.DepartRequest")
  .build());
withRawTypeToken("824VLHayEe5O_py2$6HJtc13kj4=", "com.sfeir.shared.DepartProxy");
withRawTypeToken("zYRQKG$VVqFx9eMNpIr5cCWIEKQ=", "com.sfeir.shared.RegionProxy");
withRawTypeToken("yYbsFRRmDhr$NSMaZ8yRcgwSnuo=", "com.sfeir.shared.VilleProxy");
withRawTypeToken("w1Qg$YHpDaNcHrR5HZ$23y518nA=", "com.google.web.bindery.requestfactory.shared.EntityProxy");
withRawTypeToken("FXHD5YU0TiUl3uBaepdkYaowx9k=", "com.google.web.bindery.requestfactory.shared.BaseProxy");
withClientToDomainMappings("com.sfeir.server.domain.Depart", Arrays.asList("com.sfeir.shared.DepartProxy"));
withClientToDomainMappings("com.sfeir.server.domain.Region", Arrays.asList("com.sfeir.shared.RegionProxy"));
withClientToDomainMappings("com.sfeir.server.domain.Ville", Arrays.asList("com.sfeir.shared.VilleProxy"));
}}
