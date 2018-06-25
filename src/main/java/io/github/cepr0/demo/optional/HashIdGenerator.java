package io.github.cepr0.demo.optional;

import io.github.cepr0.demo.HashId;
import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.Session;
import org.hibernate.dialect.Dialect;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.id.enhanced.SequenceStyleGenerator;
import org.hibernate.internal.util.config.ConfigurationHelper;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.util.Properties;

public class HashIdGenerator implements IdentifierGenerator, Configurable {
	
	private String sequenceCallSyntax;
	
	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		long seqValue = ((Number) Session.class.cast(session)
				.createNativeQuery(sequenceCallSyntax)
				.uniqueResult()).intValue();
		return new HashId(seqValue);
	}
	
	@Override
	public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) throws MappingException {
		final JdbcEnvironment jdbcEnvironment = serviceRegistry.getService(JdbcEnvironment.class);
		final Dialect dialect = jdbcEnvironment.getDialect();
		
		final String sequencePerEntitySuffix = ConfigurationHelper.getString(
				SequenceStyleGenerator.CONFIG_SEQUENCE_PER_ENTITY_SUFFIX,
				params,
				SequenceStyleGenerator.DEF_SEQUENCE_SUFFIX
		);
		
		final String defaultSequenceName = ConfigurationHelper.getBoolean(
				SequenceStyleGenerator.CONFIG_PREFER_SEQUENCE_PER_ENTITY,
				params,
				false
		) ? params.getProperty(JPA_ENTITY_NAME) + sequencePerEntitySuffix : SequenceStyleGenerator.DEF_SEQUENCE_NAME;
		
		sequenceCallSyntax = dialect.getSequenceNextValString(ConfigurationHelper.getString(
				SequenceStyleGenerator.SEQUENCE_PARAM,
				params,
				defaultSequenceName
				)
		);
	}
}
