package com.dynoware.cargosafe.platform.iam.domain.model.queries;

import com.dynoware.cargosafe.platform.iam.domain.model.valueobjects.Roles;

/**
 * Query to get role by name.
 */
public record GetRoleByNameQuery(Roles roleName) {
}
