package com.brimworks.databind.impl;

import com.brimworks.databind.BooleanConsumer;
import com.brimworks.databind.BooleanFactory;
import com.brimworks.databind.TypeBuilderContext;
import com.brimworks.databind.TypeRegistry;
import com.brimworks.databind.TypeVisitorFactory;
import com.brimworks.databind.VisitType;

public class BooleanVisitorImpl extends AbstractVisitorImpl {
    private BooleanFactory factory;
    private BooleanConsumer consumer;

    public BooleanVisitorImpl(TypeBuilderContext context, TypeRegistry registry, BooleanConsumer consumer) {
        super(context, registry);
        if (null == consumer)
            throw new NullPointerException("expected non-null consumer");

        BooleanFactory factory = registry.getBooleanFactory();
        if (null == factory) {
            throw context.unsupportedType("No TypeFactory for boolean");
        }

        this.factory = factory;
        this.consumer = consumer;
    }

    @Override
    public TypeVisitorFactory addContext(TypeBuilderContext context) {
        return new BooleanVisitorImpl(context, registry, consumer);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void visit(Object val) {
        if (val instanceof String) {
            consumer.accept(factory.create((String) val, context));
        } else if (val instanceof Number) {
            consumer.accept(factory.create((Number) val, context));
        } else if (null == val) {
            consumer.accept(factory.createNull(context));
        } else { // Must adapt via a different visitor:
            VisitType<Object> visit = (VisitType<Object>) registry.getVisitType(val.getClass());
            visit.visit(val, this);
        }
    }

    @Override
    public void visit(boolean val) {
        consumer.accept(factory.create(val, context));
    }

    @Override
    public void visit(long val) {
        consumer.accept(factory.create(val, context));
    }

    @Override
    public void visit(int val) {
        consumer.accept(factory.create(val, context));
    }

    @Override
    public void visit(short val) {
        consumer.accept(factory.create(val, context));
    }

    @Override
    public void visit(char val) {
        consumer.accept(factory.create(val, context));
    }

    @Override
    public void visit(byte val) {
        consumer.accept(factory.create(val, context));
    }

    @Override
    public void visit(double val) {
        consumer.accept(factory.create(val, context));
    }

    @Override
    public void visit(float val) {
        consumer.accept(factory.create(val, context));
    }
}